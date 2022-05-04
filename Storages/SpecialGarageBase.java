package Storages;


// Interface
interface SpecialGarageBase {
    // }
    public void setSpecialItems(String specialitems);

    public void setHistory(String history);

    public String[] getSpecialItems();

    public String getHistory();

    public Integer getMinimumPrice();
}
