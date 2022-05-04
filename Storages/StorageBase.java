package Storages;

// Interface
interface StorageBase {
    public void setOwner(String setowner);

    public void setLocked(Boolean setlocked);
        
    public void setDescription(String setdescription);
        
    public void setSize(Integer setsize); 
        
    public void setSold(Boolean setsold); 
        
    public void setMinimumPrice(Integer minimumprice); 
        
    public void setPrice(Integer Price); 
        
    public void setMinPrice(Integer Price); 
        
    public Integer getMinimumPrice(); 

    public String getOldOwner(); 

    public String getOwner(); 
        
    public Boolean getLocked(); 
        
    public String getDescription(); 
        
    public Integer getSize();
        
    public Boolean getSold();
        
    public Integer setSold();

    public String getName(); 

    public Integer getPrice(); 
}
