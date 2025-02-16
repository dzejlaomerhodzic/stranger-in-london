package com.company;

public class Accommodation implements Comparable <Accommodation>{
    String id,name,host_id,host_name,neighbourhood,latitude,longitude,room_type;
    Double price, distance;
    Integer minimum_nights;
    public Accommodation(String id, String name, String host_id, String host_name, String neighbourhood, String latitude, String longitude, String room_type, String price, String minimum_nights) {
        this.id = id;
        this.name = name;
        this.host_id = host_id;
        this.host_name = host_name;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.room_type = room_type;
        this.price = Double.valueOf(price);
        this.minimum_nights = Integer.valueOf(minimum_nights);
        this.distance = getDistanceFromBig_Ben(Double.valueOf(latitude), Double.valueOf(longitude));

    }

    public Accommodation(String s) {
        String []parts = s.split("\t");
       int  brojac = 0;
        for (String st:parts) {
            brojac++;
        }
        if (brojac<10){

            this.id = "";
            this.name = "";
            this.host_id = "";
            this.host_name = "";
            this.neighbourhood = "";
            this.latitude = "";
            this.longitude = "";
            this.room_type = "";
            this.minimum_nights = 0;
            this.price = 0.;
            this.distance = 0.;

        }
        else {
            this.id = parts[0];
            this.name = parts[1];
            this.host_id = parts[2];
            this.host_name = parts[3];
            this.neighbourhood = parts[4];
            this.latitude = parts[5];
            this.longitude = parts[6];
            this.room_type = parts[7];
            this.minimum_nights = Integer.valueOf(parts[8]);
            this.price = Double.valueOf(parts[9]);
            this.distance = getDistanceFromBig_Ben(Double.valueOf(latitude), Double.valueOf(longitude));
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getMinimum_nights() {
        return minimum_nights;
    }

    public void setMinimum_nights(Integer minimum_nights) {
        this.minimum_nights = minimum_nights;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Double getDistanceFromBig_Ben(Double lat1, Double lon1) {
        Double R = 6371.; // Radius of the earth in km
        Double lat2, lon2;
        lat2 = 51.5007;
        lon2 = 0.1246;
        Double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        Double dLon = deg2rad(lon2 - lon1);
        Double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double d = R * c; // Distance in km
        return d;
    }

    public static Double deg2rad(Double deg) {
        return deg * (Math.PI / 180);
    }



    @Override
    public int compareTo(Accommodation o) {
        return (int) (this.price-o.price);
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "name='" + name + '\'' +
                ", price=" + price + " " + room_type +
                '}';
    }
}
