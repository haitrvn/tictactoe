package com.haitrvn.coreui.di

import androidx.compose.runtime.Composable
import org.koin.compose.currentKoinScope
import org.koin.compose.koinInject
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

@OptIn(KoinInternalApi::class)
@Composable
inline fun <reified T> koinInjectAppQualifier(
    qualifier: Qualifier? = APP_QUALIFIER,
    scope: Scope = currentKoinScope(),
    noinline parameters: ParametersDefinition,
): T {
    return koinInject<T>(qualifier, scope, parameters)
}

@OptIn(KoinInternalApi::class)
@Composable
inline fun <reified T> koinInjectHomeQualifier(
    qualifier: Qualifier? = HOME_QUALIFIER,
    scope: Scope = currentKoinScope(),
    noinline parameters: ParametersDefinition,
): T {
    return koinInject<T>(qualifier, scope, parameters)
}

val HOME_QUALIFIER = named("HOME")
val APP_QUALIFIER = named("APP")