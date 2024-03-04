public class doctor {
    public String doctorName;
    private String doctorSubject;
    private String doctorWorkTime;
    public doctor(String doctorName, String doctorSubject, String doctorWorkTime)
    {
        this.doctorName = doctorName;
        this.doctorSubject = doctorSubject;
        this.doctorWorkTime = doctorWorkTime;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public void setDoctorSubject(String doctorSubject) {
        this.doctorSubject = doctorSubject;
    }
    public void setDoctorWorkTime(String doctorWorkTime) {
        this.doctorWorkTime = doctorWorkTime;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public String getDoctorSubject() {
        return doctorSubject;
    }

    public String getDoctorWorkTime() {
        return doctorWorkTime;
    }
}

