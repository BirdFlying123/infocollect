package uestc.model.entity.vo;

public class UserVo {
    private int id;

    private String email;

    private String institution;

    private String question;

    private String answer;

    public UserVo() {
    }

    public UserVo(int id, String email, String institution, String question, String answer) {
        this.id = id;
        this.email = email;
        this.institution = institution;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", institution='" + institution + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
