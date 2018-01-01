package Ch5;

public class Car {
    private String manufacturer;
    private String modelName;
    private int modelYear = -1;
    private String licensePlate = "";

    public Car(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public Car(String manufacturer, String modelName, int modelYear) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    public Car(String manufacturer, String modelName, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.licensePlate = licensePlate;
    }

    public Car(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}