package Data;

public class DiagnoseInf {
    private String zhusu;//主诉
    private String xianbingshi;//现病史
    private String zhiliaoqingkuang;//治疗情况
    private String jiwangshi;//既往史
    private String diagnose;//诊断信息
//纯文本类，用于存储诊断信息，诊断信息为哈希map的值。键为诊断完成的挂号信息。
//存在键值关系的挂号可以去开药
public DiagnoseInf(String zhusu,String xianbingshi ,String zhiliaoqingkuang,String jiwangshi,String diagnose){
    this.zhusu=zhusu;
    this.xianbingshi=xianbingshi;
    this.zhiliaoqingkuang=zhiliaoqingkuang;
    this.jiwangshi=jiwangshi;
    this.diagnose=diagnose;
}
    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        this.zhusu = zhusu;
    }

    public String getXianbingshi() {
        return xianbingshi;
    }

    public void setXianbingshi(String xianbingshi) {
        this.xianbingshi = xianbingshi;
    }

    public String getZhiliaoqingkuang() {
        return zhiliaoqingkuang;
    }

    public void setZhiliaoqingkuang(String zhiliaoqingkuang) {
        this.zhiliaoqingkuang = zhiliaoqingkuang;
    }

    public String getJiwangshi() {
        return jiwangshi;
    }

    public void setJiwangshi(String jiwangshi) {
        this.jiwangshi = jiwangshi;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}
