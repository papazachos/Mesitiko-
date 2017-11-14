/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiros_vasi;

/**
 *
 * @author Spiros2
 */
public class Spiros_Vasi {

   String id = dbRef.push().getKey();
        String editLastname = editlastname.getText().toString().trim();
        String editFirstname = editfirstname.getText().toString().trim();
        String editEmail = editemail.getText().toString().trim();
        String editTel = edittel.getText().toString().trim();
        String editAddress = editaddress.getText().toString().trim();
        String editCountry = editcountry.getText().toString().trim();
        String editTk = edittk.getText().toString().trim();
        String editComments = editcomments.getText().toString().trim();
        String rent = editrent.getSelectedItem().toString();
        String house = edithouse.getSelectedItem().toString();
        Vasi2 vasi = new Vasi2(id, editLastname, editFirstname, editEmail, editTel, rent, house, editAddress, editCountry, editTk, editComments);

        dbRef.child(id).setValue(vasi);
    
}


public class Vasi2 {
    String vasiid;
    String vasilastname;
    String vasifirstname;
    String vasiemail;
    String vasitel;
    String vasirent;
    String vasihouse;
    String vasiaddress;
    String vasicountry;
    String vasitk;
    String vasicomments;

    public Vasi2(){

    }

    public Vasi2(String vasiid, String vasilastname, String vasifirstname, String vasiemail, String vasitel, String vasirent, String vasihouse, String vasiaddress, String vasicountry, String vasitk, String vasicomments) {
        this.vasiid = vasiid;
        this.vasilastname = vasilastname;
        this.vasifirstname = vasifirstname;
        this.vasiemail = vasiemail;
        this.vasitel = vasitel;
        this.vasirent = vasirent;
        this.vasihouse = vasihouse;
        this.vasiaddress = vasiaddress;
        this.vasicountry = vasicountry;
        this.vasitk = vasitk;
        this.vasicomments = vasicomments;
    }

    public String getVasiid() {
        return vasiid;
    }

    public String getVasilastname() {
        return vasilastname;
    }

    public String getVasifirstname() {
        return vasifirstname;
    }

    public String getVasiemail() {
        return vasiemail;
    }

    public String getVasitel() {
        return vasitel;
    }

    public String getVasirent() {
        return vasirent;
    }

    public String getVasihouse() {
        return vasihouse;
    }

    public String getVasiaddress() {
        return vasiaddress;
    }

    public String getVasicountry() {
        return vasicountry;
    }

    public String getVasitk() {
        return vasitk;
    }

    public String getVasicomments() {
        return vasicomments;
    }
}
}