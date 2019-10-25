package com.android.miprimerapp.clases;



public class DataBase {
    private Personas firstPerson= new Personas("Jorge", "Herrera",  27,  " zona 5",  false );
    private Personas secondPerson= new Personas("Angel", "Chic", 28, "zona 8", true);

    public DataBase(){
        String nombreFirstName=firstPerson.getMyName();
        Integer resultado=firstPerson.quieroQueReste(10,8);
        resultado=firstPerson.quieroQueReste(12,6);
        resultado=secondPerson.quieroQueReste(10,5);
        firstPerson.setLastName("Arroyo");
        String nuevoApellido=firstPerson.getLastName();
    }

}
