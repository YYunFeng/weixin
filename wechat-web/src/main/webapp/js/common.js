/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
function logout() {
    jQuery.ajax({
        type: "POST",
        url: "/logout.action",
        dataType: "JSON",
        success: function (data) {
            if (data == 1) {
                window.location = "/login.action";
            }
        }
    });
}