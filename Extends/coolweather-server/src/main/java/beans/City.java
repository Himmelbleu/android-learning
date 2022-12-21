package beans;

public class City {

  private int id;
  private int citycode;
  private String cityname;
  private int provinceid;

  public City() {
  }

  public City(int id, int citycode, String cityname, int provinceid) {
    this.id = id;
    this.citycode = citycode;
    this.cityname = cityname;
    this.provinceid = provinceid;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCitycode() {
    return citycode;
  }

  public void setCitycode(int citycode) {
    this.citycode = citycode;
  }

  public String getCityname() {
    return cityname;
  }

  public void setCityname(String cityname) {
    this.cityname = cityname;
  }

  public int getProvinceid() {
    return provinceid;
  }

  public void setProvinceid(int provinceid) {
    this.provinceid = provinceid;
  }
}
