@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.BottomNavigationBar
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import cookapp.resources.app.Res
import cookapp.resources.app.ic_app_home
import cookapp.resources.app.ic_app_search
import cookapp.resources.app.ic_app_setting
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title
import org.koin.compose.LocalKoinScope
import org.koin.core.Koin
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.getScopeName
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.mp.KoinPlatform.getKoin

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()
    val navController = rememberNavController()
    val navigator: Navigator by remember(navController) {
        mutableStateOf(getKoin().get<Navigator>(parameters = { parametersOf(navController) }))
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isShowScaffold = currentRoute?.contains(Main::class.qualifiedName.toString()) == true
    KoinNavGraphScope(navController) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            bottomBar = {
                if (isShowScaffold) {
                    BottomNavigationBar(
                        items = navigationItemsLists,
                        currentRoute = currentRoute,
                        onItemClick = { item ->
                            navigator.navigate(
                                destination = item.destination,
                                popUpToRoute = Main,
                                restoreState = true,
                                popUpToSaveState = true
                            )
                        },
                        onItemReClick = { shouldReload, item ->
                            navigator.navigate(
                                destination = item.destination,
                                popUpToRoute = item.destination,
                                popUpToInclusive = true,
                                popUpToSaveState = true
                            )
                        })
                }
            }) {
            SharedTransitionLayout {
                Box(modifier = Modifier.background(AppColors.background).padding(it)) {
                    MainGraph(
                        navController = navController,
                        navigator = navigator,
                        startDestination = Auth,
                        sharedTransitionScope = this@SharedTransitionLayout,
                    )
                }
            }
        }
    }
}

val navigationItemsLists by lazy {
    listOf(
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_home,
            selectedIcon = Res.drawable.ic_app_home,
            title = Res.string.presentation_bottom_main_title,
            destination = Main.Home,
            startDestination = Main.Home.Home1,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_search,
            selectedIcon = Res.drawable.ic_app_search,
            title = Res.string.presentation_bottom_search_title,
            destination = Main.Search,
            startDestination = Main.Search.Search1,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_home,
            selectedIcon = Res.drawable.ic_app_home,
            title = Res.string.presentation_bottom_search_title,
            destination = Main.Notification,
            startDestination = Main.Notification.Notification1,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Main.Setting,
            startDestination = Main.Setting.Setting1,
        ),
    )
}

@OptIn(KoinInternalApi::class)
@Composable
internal fun KoinNavGraphScope(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val koin = getKoin()
    val currentScope = LocalKoinScope.current

    var scope by remember {
        mutableStateOf(currentScope)
    }

    DisposableEffect(navController) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            val navScopeEntry = navController.getNavScopeEntryOrNull(destination, koin)
            scope = if (navScopeEntry == null) {
                koin.scopeRegistry.rootScope
            } else {
                koin.getScopeOrNull(navScopeEntry) ?: NavScopeComponent(navScopeEntry).scope
            }
        }
        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    CompositionLocalProvider(
        LocalKoinScope provides scope,
        content
    )
}

internal fun Koin.getScopeOrNull(entry: NavBackStackEntry): Scope? {
    return getScopeOrNull(requireNotNull(entry.destination.route))
}

internal fun NavController.getNavScopeEntryOrNull(
    destination: NavDestination,
    koin: Koin
): NavBackStackEntry? {
    return getNavScopeRouteOrNull(destination, koin)?.let { route ->
        getBackStackEntry(route)
    }
}

internal fun NavController.getNavScopeRouteOrNull(
    destination: NavDestination,
    koin: Koin
): String? {
    val navScopes = koin.navScopes
    return destination.ancestors
        .mapNotNull { it.route }
        .firstOrNull { it in navScopes }
}


@OptIn(KoinInternalApi::class)
internal val Koin.navScopes: Set<String>
    get() {
        val rootScopeName = scopeRegistry.rootScope.getScopeName().value
        return scopeRegistry.scopeDefinitions
            .map { it.toString() }
            .filter { it != rootScopeName }
            .toSet()
    }

internal val NavDestination.ancestors: Sequence<NavGraph>
    get() = generateSequence(parent) { it.parent }

@OptIn(KoinInternalApi::class)
internal class NavScopeComponent(
    entry: NavBackStackEntry,
) : KoinScopeComponent, LifecycleEventObserver {

    private val route = requireNotNull(entry.destination.route)

    override val scope: Scope = getKoin().createScope(route, named(route))

    init {
        entry.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            scope.close()
        }
    }
}