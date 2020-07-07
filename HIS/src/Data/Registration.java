package Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Registration {
    private Patient p;//挂号的患者
    private Doctor d;//看诊医生
    private String paymentCategory;//结算类别 自费，医保,新农合
    private Date regDate;//看诊日期
    private String recordKind;//号别 普通号，专家号,急诊
    private int  cost;//应收金额
    private String payment;//收款方式。现金，支付宝，微信，网银，visa
   private ArrayList<Prescription> prescriptionList=new ArrayList<>();//处方的list.初始的时候为null
    private String card;//发票号
    private boolean ifFinish;//是否诊断完
private boolean ifPay;//是否结账
public Registration(Patient p, Doctor d, String paymentCategory, String recordKind, int  cost, String payment, String card, Date regDate, boolean ifFinish, ArrayList<Prescription> prescriptionList){
this.p=p;
this.d=d;
this.paymentCategory=paymentCategory;
this.recordKind=recordKind;
this.cost=cost;
this.payment=payment;
this.card=card;
this.regDate=regDate;
this.prescriptionList=prescriptionList;
this.ifFinish=ifFinish;
this.ifPay=false;
}
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(ArrayList<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public Registration(){}

    public boolean isIfFinish() {
        return ifFinish;
}

    public void setIfFinish(boolean ifFinish) {
        this.ifFinish = ifFinish;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Doctor getD() {
        return d;
    }

    public void setD(Doctor d) {
        this.d = d;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRecordKind() {
        return recordKind;
    }

    public void setRecordKind(String recordKind) {
        this.recordKind = recordKind;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean isIfPay() {
        return ifPay;
    }

    public void setIfPay(boolean ifPay) {
        this.ifPay = ifPay;
    }
}
