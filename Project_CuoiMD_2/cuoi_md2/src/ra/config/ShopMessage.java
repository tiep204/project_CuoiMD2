package ra.config;

public class ShopMessage {
    public static final String ACCOUNT = "admintiep";
    public static final String PASSWORD = "123456";
    public static final String NOTIFY_LIBRATYMANAGENMENT_CHOICE = " vui lòng chọn tử 1-5";
    public static final String NOTIFY_CATALOGMANAGEMENT_CHOICE = " vui lòng chọn từ 1-6";
    public static final String NOTIFY_BOOKMANAGEMENT_CHOICE = "vui lòng chọn từ 1-7";
    public static final String NOTIFY_USERMANAGEMENT_CHOICE = "vui lòng chọn từ 1-6";
    public static final String NOTFY_LIBRARYBOOKCARDMANAGEMENT_CHOICE = "vui lòng chọn từ 1-5";
    public static final String NOTIFY_LOGINMANAGEMENT_CHOICE = "vui long nhap tu 1-3";
    public static final String NOTIFY_LOGINMANAGEMENT_CHOICEE = "CHỨC NĂNG ĐĂNG KÝ ĐANG BẢO TRÌ !! VUI LÒNG THỬ LẠI";
    public static final String NOTIFY_USERIMPL_LOCIN_ = "Tên đăng nhập hoặc mật khẩu không chính xác";
    public static final String NOTIFY_USERIMPL_LOCIN = "Đăng nhập thành công:";
    public static final String NOTIFY_USERIMPL_LOCIN1 = "mời bạn nhập tên tài khoản vào đay:";
    public static final String NOTIFY_USERIMPL_PASSWORD = "Nhập mật khẩu vào đây:";
    public static final String NOTIFY_USERIMPL_UPDATE = "Nhap vao ten nguoi dung cap nhat: ";
    public static final String NOTIFY_USERIMPL_PHONE ="Nhap vao so dien thoai can cap nhat: " ;
    public static final String NOTIFY_USERIMPL_EMAIL = "Nhập vào email mà bạn muốn cập nhật: ";
    public static final String NOTIFY_USERIMPL_ADDRESS = "Nhập vào địa chỉ mà bạn muốn cập nhật: ";
    public static final String NOTIFY_USERIMPL_DELETEEE = "Vui lòng nhập id mà bạn muốn xóa:";
    public static final String NOTIFY_USERIMPL_DELETEEE_DELETE = "xóa thành công";
    public static final String NOTIFY_USERIMPL_DELETEEE_NOT_DELETE = "id của bạn không hợp lệ: ";
    public static final String NOTIFY_USERIMPL_DISPLAYDATA_DATE = "dd/MM/yyyy";
    public static final String NOTIFY_USERIMPL_DISPLAYDATA = "Danh sách của bạn đang bị trống";
    public static final String NOTIFY_USERIMPL_INPUTDATA = "Mời bạn nhập tên người đọc (từ 6-50) ký tự";
    public static final String NOTIFY_USERIMPL_INPUTDATA_NAME = "^[a-z0-9]{6,50}$";
    public static final String NOTIFY_USERIMPL_INPUTDATA_NOTNAME = "vui lòng nhập từ 6-50 ký tự";
    public static final String NOTIFY_USERIMPL_INPUTDATA_NOTNOTNAME = "Tên này đã tồn tại";
    public static final String NOTIFY_USERIMPL_INPUTDATA_PHONE = "hãy nhập số điện thoại của bạn vào đây";

    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_PHONE = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$";
    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_NOT_PHONE = "Bạn đã sai định dạng số điện thoại của việt nam";
    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_EMAIL ="hãy nhập email của bạn vào đây: " ;
    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_EMAILL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_NOTEMAILL = "định dạng email của bạn bị sai";
    public static final String NOTIFY_USERIMPL_INPUTDATA_ADDRESS = "nhập địa chỉ của bạn vào đây: ";
    public static final String NOTIFY_USERIMPL_INPUTDATA_LIBRARYSTARTDAY = "mời bạn nhập ngày mua thẻ thư viện vào đây(dd/MM/yyyy): ";
    public static final String NOTIFY_USERIMPL_INPUTDATA_LIBRARYENDDAY = "mời bạn nhập ngày hết hạn(dd/MM/yyyy): ";
    public static final String NOTIFY_USERIMPL_INPUTDATA_CHECK_LIBRARYDAY = "Vui lòng bạn trung thực ngày trả thẻ: ";
    public static final String NOTIFY_USERIMPL_SEARCH_CHECK_DAY = "dd/MM/yyyy";
    public static final String NOTIFY_USERIMPL_SEARCH_INPUTNAME = "Nhập vào tên danh mục mà bạn muốn tìm kiếm vào đây: ";
    public static final String NOTIFY_USERIMPL_SEARCH_INPUTNOTNAME = "khong co tên này: ";
    public static final String NOTIFY_CATALOGIMPL_DISPLAYDATA_NULL = "Danh sách của bạn Trống";
    public static final String NOTIFY_CATALOGIMPL_INPUTDATA_NAME = "moi ban nhap vao ten tu 6-50 ky tu";
    public static final String NOTIFY_CATALOGIMPL_INPUTDATA_CHECKVALI = "\\w{6,50}$";
    public static final String NOTIFY_CATALOGIMPL_INPUTDATA_NOT_CHECKVALI = "Tên này đã tồn tại";
    public static final String NOTIFY_BOOKIMPL_DELETE = "không hoạt động";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA = "ban hay nhap id  5 ky tu bat dau bang chu 'B'";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI = "^[B]\\w{4}$";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_ID = "id cua ban da ton tai";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI_NAME ="^[a-z0-9._-]{6,50}$";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI_QUATYTI = "^[^0]\\d*";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_AUTHOR = "moi ban nhap ten tac gia vao day: ";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_AUTHORCHEKVALI = "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,4}$";
    public static final String NOTIFY_BOOKIMPL_INPUTDATA_NOT_AUTHOR = "Tác giả của bạn đã tồn tại, vui lòng nhập tên mới ";
    public static final String NOTIFY_BOOKMANAGEMENT_CHOICE1 = "them moi thanh cong";
    public static final String NOTIFY_BOOKMANAGEMENT_CHOICE2 = "ko thanh cong";


}
