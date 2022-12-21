package beans;

public class County {

  private int id;
  private int cityid;
  private String countyname;
  private String weatherid;

  public County() {
  }

  public County(int id, int cityid, String countyname, String weatherid) {
    this.id = id;
    this.cityid = cityid;
    this.countyname = countyname;
    this.weatherid = weatherid;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCityid() {
    return cityid;
  }

  public void setCityid(int cityid) {
    this.cityid = cityid;
  }

  public String getCountyname() {
    return countyname;
  }

  public void setCountyname(String countyname) {
    this.countyname = countyname;
  }

  public String getWeatherid() {
    return weatherid;
  }

  public void setWeatherid(String weatherid) {
    this.weatherid = weatherid;
  }
}
