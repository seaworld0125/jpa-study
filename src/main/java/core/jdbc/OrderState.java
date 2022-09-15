package core.jdbc;

/**
 * packageName    : core.jdbc
 * fileName       : OrderState
 * author         : Kim
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-14        Kim       최초 생성
 */
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OrderState
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderState {

    REQUESTED("REQUESTED"),
    ACCEPTED("ACCEPTED"),
    SHIPPING("SHIPPING"),
    COMPLETED("COMPLETED"),
    REJECTED("REJECTED"),
    ;

    private final String msg;

    private OrderState(final String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
