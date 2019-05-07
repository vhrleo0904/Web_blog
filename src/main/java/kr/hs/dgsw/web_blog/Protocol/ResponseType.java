package kr.hs.dgsw.web_blog.Protocol;

public enum ResponseType {
    FAIL(0, "명령을 실행하지 못했습니다"),

    USER_DELETE(101, "ID [%d]의 사용자를 삭제했습니다."),
    USER_ADD(102, "ID [%d]의 사용자를 추가했습니다."),
    USER_UPDATE(103, "ID [%d]의 사용자를 수정했습니다."),
    USER_LIST(104, "총 %d명의 사용자를 불러왔습니다."),
    USER_GET(105, "ID [%d]의 사용자를 불러왔습니다."),

    POST_LIST(200, "총 %d명의 게시물을 불러왔습니다."),
    POST_GET(201, "ID [%d]의 게시물을 불러왔습니다."),
    POST_ADD(202, "ID [%d]의 게시물을 추가하였습니다."),
    POST_UPDATE(203, "ID [%d]의 게시물을 수정하였습니다."),
    POST_DELETE(204, "ID [%d]의 게시물을 삭제하였습니다."),

    ATTACHMENT_STORED(301, "ID [%d]의 첨부파일을 추가하였습니다.");

    final private int code;
    final private String desc;

    ResponseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }
}
