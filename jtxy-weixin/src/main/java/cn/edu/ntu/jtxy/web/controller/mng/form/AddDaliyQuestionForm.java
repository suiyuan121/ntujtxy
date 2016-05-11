package cn.edu.ntu.jtxy.web.controller.mng.form;

import cn.edu.ntu.jtxy.core.model.BaseModel;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: QueryDaliyQuestionInfoForm.java, v 0.1 2016年5月5日 下午4:19:55 zhangjinntu@163.com Exp $
 */
public class AddDaliyQuestionForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = 2862798257169830878L;

    private long              id;

    private String            type;

    private int               pointValue;

    private String            content;

    private String            answerCorrect;

    private String            answerOne;

    private String            answerTwo;

    private String            answerThree;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

}
