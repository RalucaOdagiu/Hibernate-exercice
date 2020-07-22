import dao.PetOwnerDao;
import model.Pet;
import model.PetOwner;

public class MainManyToMany {

  public static void main(String[] args) {
    PetOwner marco = new PetOwner("Marco");
    PetOwner bogdan = new PetOwner("Bogdan");

    Pet rufy = new Pet("Rufy");
    Pet blacky = new Pet("Blacky");
    Pet raffy = new Pet("Raffy");

    Pet puf = new Pet("Puf");
    Pet peste = new Pet("Peste balon");

    marco.setPets(rufy, blacky, raffy, peste);
    bogdan.setPets(puf, peste);

    rufy.setPetOwner(marco);
    blacky.setPetOwner(marco);
    raffy.setPetOwner(marco, bogdan);
    puf.setPetOwner(bogdan);
    peste.setPetOwner(bogdan, marco);

    PetOwnerDao petOwnerDao = new PetOwnerDao();
    petOwnerDao.saveEntity(marco);
    petOwnerDao.saveEntity(bogdan);

  }
}
