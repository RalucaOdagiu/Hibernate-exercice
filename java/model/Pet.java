package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pet_petOwner",
      joinColumns = @JoinColumn,
      inverseJoinColumns = @JoinColumn)
  private List<PetOwner> petOwners = new ArrayList<>();

  public Pet(String name) {
    this.name = name;
  }

  public void setPetOwner(PetOwner... petOwnerArray) {
    for (PetOwner petOwner : petOwnerArray) {
      petOwners.add(petOwner);
    }
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PetOwner> getPetOwners() {
    return petOwners;
  }

  public void setPetOwners(List<PetOwner> petOwners) {
    this.petOwners = petOwners;
  }
}
