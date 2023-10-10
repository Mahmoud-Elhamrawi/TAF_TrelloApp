package EndPoints;


public class Routes {


    public static String  base_url ="https://api.trello.com";
    public  static  String key ="868e7a9e6f321a076df55a330aded512";
    public  static  String token ="8e5d9705a9f0ae11d3ce7198730baa249d8e229acfd3804770ebcb377ac138d6";
    public static String  email ="mahmmahmoudelhamrawi5@gmail.com";
    // board
    public static String createBoard =base_url+"/1/boards/?name={name}&key="+key+"&token="+token;
    public static  String getBoard =base_url+"/1/boards/{idBoard}?key="+ key +"&token="+token ;

    // list
     public static  String createList = base_url+"/1/lists?name={listName}&idBoard={idBoard}&key="+key+"&token="+token ;

     //cards
    public static String createCard =base_url+"/1/cards?idList={listId}&key="+key+"&token="+token+"&name={cardName}";

    public static  String moveCard =base_url+"/1/lists/{todolistId}/moveAllCards?idBoard={idBoard}d&idList=idList&key="+key+"&token="+token;

    //labels
    public static String createLabel =base_url+"/1/boards/{idBoard}/labels?name=end to end scenario&color=red&key="+key+"&token="+token ;

    //Invite Member to Board via email
    public static String Invite =base_url+"/1/boards/{idBoard}/members?email="+email+"&key="+key+"&token="+token ;
}
