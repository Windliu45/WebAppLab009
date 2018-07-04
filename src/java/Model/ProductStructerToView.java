package Model;

public class ProductStructerToView {
    
    private String 會員編號 ;
    private String 產品編號 ;
    private String 產品名稱 ;
    private int 產品數量 ;
    private int 產品單價 ;
    
    public ProductStructerToView(){}   
    
    public ProductStructerToView(String 會員編號,String 產品編號,String 產品名稱,int 產品數量,int 產品單價,int 產品總價){
        this.會員編號 = 會員編號 ;
        this.產品編號 = 產品編號 ;
        this.產品名稱 = 產品名稱 ;
        this.產品單價 = 產品單價 ;
        this.產品數量 = 產品數量 ;
    }
    //setter

    public void set會員編號(String 會員編號) {
        this.會員編號 = 會員編號;
    }

    public void set產品編號(String 產品編號) {
        this.產品編號 = 產品編號;
    }

    public void set產品名稱(String 產品名稱) {
        this.產品名稱 = 產品名稱;
    }

    public void set產品數量(int 產品數量) {
        this.產品數量 = 產品數量;
    }

    public void set產品單價(int 產品單價) {
        this.產品單價 = 產品單價;
    }
    
    
    //getter

    public String get會員編號() {
        return 會員編號;
    }

    public String get產品編號() {
        return 產品編號;
    }

    public String get產品名稱() {
        return 產品名稱;
    }

    public int get產品數量() {
        return 產品數量;
    }

    public int get產品單價() {
        return 產品單價;
    }
    
    
    
    



    
    
    
    
}
