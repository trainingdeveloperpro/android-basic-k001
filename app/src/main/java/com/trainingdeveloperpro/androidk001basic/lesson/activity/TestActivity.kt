package com.trainingdeveloperpro.androidk001basic.lesson.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trainingdeveloperpro.androidk001basic.R
import com.trainingdeveloperpro.androidk001basic.utils.DebugLog



/**
 * https://developer.android.com/guide/components/activities.html?hl=vi
 * Tạo 1 file TestActivity.kt
 * Tạo 1 file activity_test.xml ở thư mục layout
 * Khai báo ở AndroidManifest.xml
 *
 * Bật Logcat để xem log chạy qua các hàm như thế nào
 * **/
class TestActivity : AppCompatActivity() {


    /****
     * Được gọi khi Activity mới được tạo.
     * Đây là lúc bạn nên thực hiện tất cả thiết lập cố định thông thường của mình — tạo chế độ xem, kết ghép dữ liệu với danh sách, v.v.
     * Hàm này được chuyển cho một đối tượng Bundle chứa trạng thái trước đây của Activity,
     * nếu trạng thái đó được thu lại.
     *
     * Không tắt bỏ
     *
     * Hàm chạy tiếp theo hàm này là hàm onStart()
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        DebugLog.logD(TAG, "onCreate()")
    }


    /**
     * Được gọi ngay trước khi Activity hiển thị trước người dùng.
     * Hàm tiếp theo là onResume() nếu Activity vào foreground , hoặc onStop() nếu activity bị ẩn.
     *
     * **/
    override fun onStart() {
        super.onStart()

        DebugLog.logD(TAG, "onStart()")
    }

    /**
     * Được gọi ngay trước khi Activity bắt đầu tương tác với người dùng.
     * Tại điểm này, Activity nằm ở trên cùng của Activity Stack, trong đó mục nhập của người dùng sẽ đến Activity này.
     *
     * Hàm tiếp theo hàm này là onPause
     * */
    override fun onResume() {
        super.onResume()

        DebugLog.logD(TAG, "onResume()")
    }

    /**
     * Được gọi khi hệ thống sắp bắt đầu tiếp tục một hoạt động khác. Hàm này thường được sử dụng để thực hiện các thay đổi chưa lưu cho dữ liệu liên tục,
     * dừng các hoạt ảnh và những việc khác mà có thể tiêu tốn công suất CPU, v.v. Nó sẽ thực hiện rất nhanh, vì activity tiếp theo sẽ không được tiếp tục tới khi nó trở lại
     * Hàm tiếp theo hàm này là onResume() nếu Activity trở lại phía trước, hoặc bởi onStop() nếu nó không hiển thị với người dùng.
     * Có thể bị loại bỏ
     * */
    override fun onPause() {
        super.onPause()

        DebugLog.logD(TAG, "onPause()")
    }

    /**
     * Được gọi khi Activity không còn hiển thị với người dùng. Điều này có thể xảy ra vì nó đang bị hủy, hoặc vì một Activity khác (đang tồn tại hoặc mới) đã được tiếp tục và đang che khuất nó.
     * Hàm tiếp theo là onRestart() nếu Activity đang quay lại để tương tác với người dùng, hoặc bởi onDestroy() nếu Activity này sẽ đi mất.
     * Có thể bị loại bỏ
     * */
    override fun onStop() {
        super.onStop()

        DebugLog.logD(TAG, "onStop()")
    }

    /**
     * Được gọi sau khi Activity đã được dừng, ngay trước khi Activity được bắt đầu lại.
     *
     * Hàm chạy tiếp theo là hàm onStart()
     * */
    override fun onRestart() {
        super.onRestart()

        DebugLog.logD(TAG, "onRestart()")
    }

    /**
     * Được gọi trước khi Activity bị hủy. Đây là lần gọi cuối cùng mà Activity sẽ nhận được.
     * Nên gọi nó hoặc vì Activity đang kết thúc (ai đó đã gọi finish() trên nó), hoặc vì hệ thống đang tạm thời hủy thực thể này của Activity để tiết kiệm bộ nhớ trống.
     * Bạn có thể phân biệt những những kịch bản này bằng hàm isFinishing().
     *
     * Có thể bị loại bỏ
     * */
    override fun onDestroy() {
        super.onDestroy()

        DebugLog.logD(TAG, "onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Lưu trạng thái của UI vào outState
        // Bundle này sẽ chuyển đến hàm onCreate nếu như tiến trình bị killed and restarted
        outState.putBoolean(BUNDLE_STATE_BOOLEAN, true)
        outState.putString(BUNDLE_STATE_STRING, "Welcome back to Android")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        val myBoolean = savedInstanceState.getBoolean(BUNDLE_STATE_BOOLEAN)
        DebugLog.logD(TAG, "My Boolean $myBoolean")

        val myString = savedInstanceState.getString(BUNDLE_STATE_STRING)

        DebugLog.logD(TAG, "My String $myString")
    }

    companion object {

        private val TAG = TestActivity::class.java.simpleName

        private const val BUNDLE_STATE_BOOLEAN = "BUNDLE_STATE_BOOLEAN"
        private const val BUNDLE_STATE_STRING = "BUNDLE_STATE_STRING"
    }

}