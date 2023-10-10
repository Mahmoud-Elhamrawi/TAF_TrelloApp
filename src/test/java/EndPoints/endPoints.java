package EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class endPoints {



    public  static Response createBoard(String nameBoard)
    {
        Response boardCreate = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("name" ,nameBoard)
                .when().post(Routes.createBoard);

        return boardCreate ;
    }
public static Response getBoards(String idBoard)
{
    Response getboard = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("idBoard",idBoard)
            .when().get(Routes.getBoard);

    return getboard ;
}

        public static Response createList(String listName ,String idBoard)
        {
            Response listCreate = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("listName",listName)
                    .pathParam("idBoard",idBoard)
                    .when().post(Routes.createList) ;
            return listCreate ;
        }

        public static Response createCard(String listId , String cardName)
        {
            Response listCreate = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("listId",listId)
                    .pathParam("cardName",cardName)
                    .when().post(Routes.createCard) ;
            return listCreate ;
        }

        public  static  Response moveTodoDoing(String todolistId , String idBoard ,String idList)
        {

            Response move =  given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("todolistId",todolistId)
                    .pathParam("idBoard",idBoard)
                    .queryParam("idList",idList)
                    .when().post(Routes.moveCard);

            return move ;
        }




        public static Response createLable(String idBoard)
        {
            Response label = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("idBoard",idBoard)
                    .when().post(Routes.createLabel);

            return label ;


        }



        public static Response invite(String idBoard)
        {
            Response inviteRes = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("idBoard",idBoard)
                    .when().put(Routes.Invite);
            return inviteRes ;
        }






}
