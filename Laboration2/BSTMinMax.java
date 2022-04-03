package Laboration2;

public class BSTMinMax {
    public static void main(String[] args) {
        BST<Mayagudar> gudar = new BST<>();
        gudar.add(new Mayagudar("Chaac", "Regn och åska","Chaac är mestadels en grupp åskgudar med anknytning till regn i mayaindianernas mytologi. De ansågs välvilligt inställda gentemot människorna och förknippades också med fruktbarhet och var därför viktiga som lantbruksgudar."));
        gudar.add(new Mayagudar("Ah Puch","Döden","Ah Puch eller Ah Puh var i mayaindianernas mytologi en dödsgud, och härskare över Metnal, det värsta av de nio helvetena i underjorden, Xibalba."));
        gudar.add(new Mayagudar("Bolon Dzacab","Förfader","Bolon Dzacab är en förfadersgud hos Mayafolket i dagens Mexiko. Han avbildas på monument som attribut för prominenta personer."));
        gudar.add(new Mayagudar("Camazotz","Fladdermus","Camazotz, även benämnd Zotz, var en fladdermusgud i mayansk mytologi som härskade över det mörka \"fladdermusrummet\"[1]. Rummet låg i underjorden (Xibalba) och var omöjligt att fly från. Det finns också en bok som handlar om Camazotz. Det sägs att han hade ett tempel där en av fyra amuletter förvarades. En amulett såg ut som en fladdermus, en som en krona, och en som en halvmåne, och den sista ett öga. När de fyra amuletterna sammanfördes, skulle evig ondska härska (enligt mayansk tro)."));
        gudar.add(new Mayagudar("Hunahpu","Skapelse","Hunahpu eller Hunahpu-Vuch var en skapelsegud hos mayafolket i Mexiko men också gryningens och solens gud.\n"+"Hunahpu intog olika gestalter och förknippades ibland med rävhonan och koyoten. Dock finns en förmodligen distinkt gestalt som bär samma namn, nämligen den ungdomlige hjälte som tillsammans med sin tvillingbror Xbalanque bekämpade Vucub-Caquix och hans högfärdiga söner.\n"+"\"Vuch\" är den korta skymningstiden precis innan gryningen."));
        gudar.add(new Mayagudar("Ah Kinchil","Sol","Ah Kinchil eller Kinich Ahau (med flera namnformer) var i mytologin hos mayaindianerna en solgud med samma yttre kännetecken som Itzamna."));
        gudar.add(new Mayagudar("Ix Ch'up","Måne","Ix Ch'up (\"Kvinnan\") var mångudinna hos mayaindianerna i Mexiko."));
        gudar.add(new Mayagudar("Gucumatz","Skapelse och orm","Gucumatz deltog i alltings skapelse men hörde av allt att döma inte till de omnipotentas krets. Han misslyckades vid ett par tillfällen att skapa livskraftiga och dugliga varelser, varpå flera släkten gick under i översvämningar eller förvandlades till apor. Till slut skapade han och hans efterträdare Tepeu människan av majs och lyckades få till en varelse god nog att hylla gudarna och bringa dem gåvor."));
        gudar.add(new Mayagudar("Kukulcán","Krig","Kukulcán (av Kukul, befjädrad och can, orm), även känd som Quetzalcóatl, var en av de viktigaste gudarna hos Maya- och Toltekindianerna i Mexiko.\n"+"Kukulcán framställs på byggnaderna i Yucatan och Teotihuakan som en befjädrad orm. I legenderna om honom berättas det att han anlände från väst och grundade sitt kungarike i Chichén Itzá. Han identifierades också med planeten Venus och kallas även Venus."));

        System.out.println(gudar.size());

        System.out.println(gudar.min().getName());
        System.out.println(gudar.max().getName());
    }
}
