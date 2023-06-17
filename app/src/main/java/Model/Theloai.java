package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Theloai {

@SerializedName("idtheloai")
@Expose
private String idtheloai;
@SerializedName("idchude")
@Expose
private String idchude;
@SerializedName("tentheloai")
@Expose
private String tentheloai;
@SerializedName("hinhtheloai")
@Expose
private String hinhtheloai;

public String getIdtheloai() {
return idtheloai;
}

public void setIdtheloai(String idtheloai) {
this.idtheloai = idtheloai;
}

public String getIdchude() {
return idchude;
}

public void setIdchude(String idchude) {
this.idchude = idchude;
}

public String getTentheloai() {
return tentheloai;
}

public void setTentheloai(String tentheloai) {
this.tentheloai = tentheloai;
}

public String getHinhtheloai() {
return hinhtheloai;
}

public void setHinhtheloai(String hinhtheloai) {
this.hinhtheloai = hinhtheloai;
}

}