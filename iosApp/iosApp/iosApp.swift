import SwiftUI
import ComposeApp

@main
struct ComposeApp: App {
  init() {
    MainKt.doInitInjection()
  }

  var body: some Scene {
    WindowGroup {
      GeometryReader { geo in
        ContentView(
          top: Float(geo.safeAreaInsets.top),
          bottom: Float(geo.safeAreaInsets.bottom),
          start: Float(geo.safeAreaInsets.leading),
          end: Float(geo.safeAreaInsets.trailing)
        )
        .ignoresSafeArea(.all)
      }
    }
  }
}

struct ContentView: UIViewControllerRepresentable {
  var top: Float
  var bottom: Float
  var start: Float
  var end: Float

  init(top: Float, bottom: Float, start: Float, end: Float) {
    self.top = top
    self.bottom = bottom
    self.start = start
    self.end = end
  }

  func makeUIViewController(context: Context) -> UIViewController {
    return MainKt.MainViewController(topPadding: top, bottomPadding: bottom, startPadding: start, endPadding: end)
  }

  func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
