package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }
    
    @Override
    public void selectCalcRadius( String value ) {
        double valueDouble = 0;
        try {
            valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
            if (valueDouble < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Entrez une valeur et non du texte");

        } catch (IllegalArgumentException exception) {
            refIhm.afficheMessage("Entrez une valeur positive");

        }
    }

      @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        refIhm.afficheMessage(" ");
        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;

        try {

            valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
            if (valueLongueurDouble < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Entrez une valeur et non du texte pour le champ de la longueur");

        } catch (IllegalArgumentException exception) {
            refIhm.afficheMessage("Entrez une valeur positive pour le champ de la longueur");

        }

        //other
        try {
            valueAreaDouble = Double.parseDouble(valueArea);

            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
            if (valueAreaDouble < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Entrez une valeur et non du texte pour le champ de l'aire");

        } catch (IllegalArgumentException exception) {
            refIhm.afficheMessage("Entrez une valeur positive pour le champ de l'aire");

        }

    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
