# Cấu trúc Source Code - CookApp (tictactoe)

Tài liệu này cung cấp cái nhìn tổng quan về cấu trúc code, kiến trúc và các đề xuất cải thiện cho dự án.

## 1. Tổng quan Kiến trúc

Dự án được xây dựng theo mô hình **Clean Architecture** kết hợp với **Multi-module** trong **Kotlin Multiplatform (KMP)**. Đây là một kiến trúc hiện đại, có khả năng mở rộng cao và cho phép chia sẻ code logic giữa các nền tảng (Android, JVM/Desktop, WASM).

### Sơ đồ phân lớp (Layers)

*   **`composeApp`**: Module chính (Entry Point). Nơi khởi tạo ứng dụng, cấu hình Dependency Injection (Koin) và định nghĩa biểu đồ điều hướng chính (Main Graph).
*   **`features/`**: Chứa các module chức năng (Feature modules). Mỗi feature (như `auth`, `home`, `splash`) tự đóng gói logic UI (Compose) và ViewModel riêng.
*   **`domain`**: Lớp chứa Business Logic thuần túy. Bao gồm Entities (models), Use Cases và Repository Interfaces. Không phụ thuộc vào bất kỳ framework nào.
*   **`data`**: Lớp dữ liệu. Triển khai các Repository Interfaces từ lớp Domain. Phụ thuộc vào `domain`. Chứa logic Networking, Database và Data Mapping.
*   **`core/` & `coreui/`**: Các module dùng chung. `core` chứa các tiện ích logic, trong khi `coreui` chứa Design System (Theme, Common Components).
*   **`navigation`**: Module quản lý các Route và logic điều hướng tập trung.
*   **`buildSrc`**: Chứa logic cấu hình Build (Convention Plugins) giúp quản lý dependency và cấu hình gradle tập trung.

---

## 2. Chi tiết các Module

| Module | Nhiệm vụ |
| :--- | :--- |
| `:composeApp` | Wiring tất cả các module, khởi chạy ứng dụng trên Android/Desktop/WASM. |
| `:features:auth` | Logic Đăng nhập/Đăng ký. |
| `:features:home` | Màn hình chính và các logic liên quan đến trang chủ. |
| `:domain` | Chứa các Business Rules (SplashUseCase, UserLoginUseCase) và Models (User, Recipe). |
| `:data` | Thực thi việc lấy dữ liệu (SplashRepositoryImpl, UserLoginRepositoryImpl). |
| `:coreui` | Thành phần giao diện dùng chung (Button, Input, Theme). |
| `:navigation` | Định nghĩa `Destination` và các tham số truyền giữa các màn hình. |

---

## 3. Đánh giá Ưu điểm

1.  **Tính đóng gói (Encapsulation) tốt**: Việc chia nhỏ thành các feature module giúp giảm thiểu sự phụ thuộc lẫn nhau, hỗ trợ build song song (parallel build) tốt hơn.
2.  **Áp dụng Clean Architecture**: Giúp code dễ test hơn (đặc biệt là lớp Domain).
3.  **Hệ thống Build chuyên nghiệp**: Sử dụng `buildSrc` và Convention Plugins giúp các file `build.gradle.kts` ở các module con rất gọn nhẹ và dễ bảo trì.
4.  **KMP Ready**: Cấu trúc các module đã sẵn sàng cho đa nền tảng với việc sử dụng `commonMain`, `androidMain`, `iosMain`, v.v.
5.  **Design System**: Module `coreui` được xây dựng rất bài bản, hỗ trợ Dark Mode và đa nền tảng.

---

## 4. Những điều cần điều chỉnh & Sửa đổi (Recommendations)

### A. Tính nhất quán (Naming & Consistency)
*   **Tên dự án**: Thư mục gốc là `tictactoe` nhưng toàn bộ code và cấu hình Gradle gọi là `CookApp`. Nên đổi tên thư mục gốc thành `CookApp` để tránh nhầm lẫn.
*   **Typo trong Package**:
    *   `data/src/commonMain/kotlin/com/haitrvn/data/mode` -> Cần đổi thành `model`.
    *   `coreui/src/commonMain/kotlin/com/haitrvn/coreui/component/Divier.kt` -> Cần đổi thành `Divider.kt`.
*   **Module dư thừa**: Module `:presentation` ở thư mục gốc hiện đang trống và không được sử dụng rõ ràng. Nếu logic Presentation đã nằm trong các feature, nên xóa module này hoặc sử dụng nó cho logic presentation dùng chung.

### B. Logic Code (Code Quality)
*   **`LoginViewModel.kt`**:
    *   Tại dòng 55: Đang gọi `validateUserName(password)`. Lẽ ra phải là `validatePassword(password)`.
    *   Logic đăng nhập hiện tại (dòng 73-74) đang hardcode `admin`/`password`. Cần chuyển logic này vào Use Case hoặc Repository sau khi thực hiện gọi API thực tế.
    *   Kết quả từ `userLoginUseCase.invoke(...)` hiện đang bị bỏ qua và chỉ dùng để set `isLoading`. Nên sử dụng kết quả từ Use Case để cập nhật UI State hoặc Error Message.

### C. Resource Management
*   **Resource Package**: Trong `features/auth`, `packageOfResClass` được đặt là `cookapp.resources.auth`. Hãy đảm bảo quy tắc đặt tên này đồng nhất ở tất cả các feature để dễ dàng truy cập resource.

---

## 5. Kết luận

Source code dự án hiện tại có **cấu trúc rất tốt**, tuân thủ các chuẩn mực hiện đại của Android và KMP development. Nếu khắc phục được các vấn đề về đặt tên và tính nhất quán nêu trên, dự án sẽ rất dễ bảo trì và phát triển lâu dài.
