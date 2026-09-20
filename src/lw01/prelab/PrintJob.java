package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " |" + calculateCharge();
    }

}