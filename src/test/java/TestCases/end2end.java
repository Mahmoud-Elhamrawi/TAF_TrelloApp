package TestCases;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class end2end {
    public static String idBoard ;
    public static String listId1 ;
    public static String listId2 ;
    public static String listId3 ;
    public static String cardId1 ;
    public static String cardId2 ;
    public static String cardId3 ;

    @Test(priority = 0)
    public void CreateBoard()
    {
        Response createBoard = EndPoints.endPoints.createBoard("board.v7");

        createBoard.prettyPrint() ;
          // trelloDe_Serialization boardInfo = createBoard.body().as(trelloDe_Serialization.class);
          //idBoard =boardInfo.getId() ;
        Assert.assertEquals(createBoard.statusCode() ,200) ;
        idBoard = createBoard.body().jsonPath().get("id");
        System.out.println(createBoard.body().jsonPath().get("id").toString() );
    }

    @Test(priority = 1)
    public void getBoard()
    {
      Response getBoard =EndPoints.endPoints.getBoards(idBoard) ;
      getBoard.prettyPrint() ;
      Assert.assertEquals(getBoard.statusCode() , 200 );
    }


    @Test(priority = 2)
     public void createList()
    {
            Response createlist1 =  EndPoints.endPoints.createList("doneList",idBoard);
            createlist1.prettyPrint() ;
            listId1 =createlist1.body().jsonPath().get("id");

            Assert.assertEquals(createlist1.statusCode() ,200);

        }

    @Test(priority = 3)
    public void createList2()
    {
        Response createlist2 =  EndPoints.endPoints.createList("doingList" ,idBoard);
        createlist2.prettyPrint() ;

        listId2 =createlist2.body().jsonPath().get("id");


        Assert.assertEquals(createlist2.statusCode() ,200);

    }
    @Test(priority = 4)
    public void createList3()
    {
        Response createlist3 =  EndPoints.endPoints.createList("todoList" ,idBoard);
        createlist3.prettyPrint() ;
        listId3 =createlist3.body().jsonPath().get("id");
        Assert.assertEquals(createlist3.statusCode() ,200);

    }


    @Test(priority = 5)
    public void createCard1()
  {
          System.out.println(listId1);
        Response cardRes1 =  EndPoints.endPoints.createCard(listId1 , "card3.1");
        cardId1 =cardRes1.body().jsonPath().get("id");
        cardRes1.prettyPrint() ;
        Assert.assertEquals(cardRes1.statusCode() , 200);
       System.out.println(cardId1);
  }

    @Test(priority = 6)
    public void createCard2()
    {
        System.out.println(this.listId2);
        Response cardRes2 =  EndPoints.endPoints.createCard(this.listId2 , "card2");
        this.cardId2 =cardRes2.body().jsonPath().get("id");
        cardRes2.prettyPrint() ;
        Assert.assertEquals(cardRes2.statusCode() , 200);
        System.out.println(cardId2);
    }

    @DataProvider(name = "cards")
    public Object[] provider()
    {
        String ca[]={"card1.1" , "card1.2" , "card1.3"};
        return ca ;
    }

    @Test(priority = 7 ,dataProvider = "cards")
    public void createCard3(String card)
    {
        System.out.println(listId3);
        Response cardRes3 =  EndPoints.endPoints.createCard(listId3 , card);
        cardId3 =cardRes3.body().jsonPath().get("id");
        cardRes3.prettyPrint() ;
        Assert.assertEquals(cardRes3.statusCode() , 200);
        System.out.println(cardId3);

    }



    @Test(priority = 8 , enabled = false)
    public void moveToDoDoing()
    {
        System.out.println(listId3);
        System.out.println(idBoard);
        System.out.println(listId2);
        Response moveRes =EndPoints.endPoints.moveTodoDoing(listId3 ,idBoard , listId2);
        moveRes.prettyPrint() ;
        Assert.assertEquals(moveRes.statusCode(),200);

    }

    @Test(priority = 9)
    public void createLabel()
    {
        Response labelRes = EndPoints.endPoints.createLable(idBoard);
        labelRes.prettyPrint() ;
        Assert.assertEquals(labelRes.statusCode() , 200);
    }


    @Test(priority = 10)
    public void inviteViaEmail()
    {
        Response inRes = EndPoints.endPoints.invite(idBoard);
        inRes.prettyPrint() ;
        Assert.assertEquals(inRes.statusCode() ,200);
    }

}
