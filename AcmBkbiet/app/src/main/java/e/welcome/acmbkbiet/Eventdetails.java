package e.welcome.acmbkbiet;

public class Eventdetails {
    String image,name,description,venue,time,pid,date;

    public Eventdetails() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Eventdetails(String image, String name, String description, String venue, String time, String pid, String date) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.venue = venue;
        this.time = time;
        this.pid = pid;
        this.date = date;
    }
}
