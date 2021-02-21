public class Main {
    public static void main(String[] args) {
        Rubbers Filee = new Rubbers("Филле", "Ищет серебрянную посуду", false);
        Rubbers Rulee = new Rubbers("Рулле", "Начал выдвигать ящики секретаря", false);
        Kid Mal = new Kid("Малыш", "Боится в соседней комнате", true);
        Box b1 = new Box(false, ContentOfBox.Money, 1);
        Box b2 = new Box(false, ContentOfBox.RingsAndBrooch, 2);
        GHOST ghost = new GHOST("Призрак", "Молчит", "Буфет");
        Door d = new Door(false, "Буфетные дверцы");


        Filee.Move("Кухня");
        System.out.println(Filee.getName() + " находится в комнате: " + Filee.getLocation() + "!");

        Rulee.Open(b1);
        if (b1.getOpenStatus() == true) {
            System.out.println(b1.getLocation() + " открылся!");
            System.out.println(Rulee.getName() + " нашёл " + b1.GetContent() + "!");
            System.out.println(Rulee.Whistle());
            Rulee.Close(b1);
            if (b1.getOpenStatus() == false){
                System.out.println(b1.getLocation() + " закрылся!");
            }
        }


        Rulee.Open(b2);
        if (b2.getOpenStatus() == true) {
            System.out.println(b2.getLocation() + " открылся!");
            System.out.println(Rulee.getName() + " нашёл " + b2.GetContent() + "!");
            System.out.println(Rulee.Whistle());
            Rulee.Close(b2);
            if (b2.getOpenStatus() == false) {
                System.out.println(b2.getLocation() + " закрылся!");
            }
        }

        if (b2.GetContent().equals(ContentOfBox.RingsAndBrooch)){
            System.out.println(Rulee.Whistle());
        }

        d.Open();

        if (d.GetStatus() == true){
            System.out.println(d.getMembership()+" открылись!");
        }

        if (d.GetStatus() == true){
            ghost.setTypeLocation("Столовая");
            ghost.setTypeSay("издаёт страшные стоны");
            System.out.println(ghost.getName()+" сейчас в комнате: "+ghost.getLocation()+"!");
            System.out.println(ghost.getName()+" "+ghost.getTypeSay()+"!");
            d.Close();
            if (d.GetStatus() == false){
                System.out.println(d.getMembership()+" зыкрылись!");
            }

        }
        else {
            System.out.println(Rulee.Whistle());
        }

        Rulee.MoveAround();

        if (Rulee.getMoveAroundStatus() == true){
            System.out.println(Rulee.getName()+" развернулся!");
            Rulee.GetScared();
        }

        if (Rulee.ScareStatus() == true){
            System.out.println(Rulee.Xruk());
            System.out.println(Rulee.Throw());
        }

        if (d.GetStatus() == true){
            System.out.println(ghost.getName()+" порхал в комнате: " + ghost.getLocation()+"!");
            ghost.setTypeSay("cтонет и вздыхает");
            System.out.println(ghost.getName()+" "+ghost.getTypeSay()+"!");
            ghost.setTypeLocation("Кухня");
            System.out.println(ghost.getName()+" устремилось в комнату: "+ghost.getLocation()+"!");
        }

        System.out.println(Filee.getName()+" пришел в комнату: "+Filee.getLocation()+"!");
        if (ghost.getLocation() == "Кухня"){
            Filee.GetScared();
        }
        if (Filee.ScareStatus() == true){
            System.out.println(Filee.getName()+" побледнел как полотно!");
        }
    }
}
