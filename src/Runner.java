import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public final class Runner implements Serializable {

    private static final long serialVersionUID = 1L;
    protected int code;
    protected String name;
    protected Time lapTime;
    protected Date lapDate;

    public Runner(int code, String name, Time lapTime, Date lapDate) {
        this.code = code;
        this.name = name;
        this.lapDate = lapDate;
        this.lapTime = lapTime;
    }

    public void printInfo() {
        System.out.println(code+"\t | "+lapDate+" \t | "+lapTime+" \t | "+name);
    }

    public String getInfo() {
        return (code + "," + name + "," + lapDate + "," + lapTime);
    }

    public static Time getRandomTime() {
        Random rand = new Random();

        final int millisInDay = 24*60*60*1000;
        Time time = new Time((long)rand.nextInt(millisInDay));
        
        return time;
    }

    public static int getRandomCode() {
        Random rand = new Random();

        return (rand.nextInt(100000000) + 1);
    }

    public static Date getRandomDate() {
        Random rand = new Random();
        long ms = -946771200000L + (Math.abs(rand.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));

        // Construct a date
        Date dt = new Date(ms);
        return dt;
    }

    public static String getRandomName() {
        Random rand = new Random();

        String[] primaryName = {"Jaina", "Jorge", "Marina", "Guilherme", "Anderson","Pedro", "Arthur", "Ricardo", "Thiago", "Maikon","Matheus", "Barbara", "Caroline", "Joao", "Jose","Vitor", "Caio", "Jonathan", "Paulo", "Ana", "Andressa","Joyce", "Enzo", "Valentina", "Vanessa", "Helena","Jack", "Cleyton", "Thays", "Bruno", "Mariana","Mari", "Larissa", "Luisa", "Ronaldo", "Leonardo","Michael", "Miguel", "Lucas", "Vitoria", "Heloisa", "Maristela", "Carlos", "Arthur", "Gustavo", "Paulo", "Bernardo", "Domigos", "Natalino", "Henrique", "Heitor", "Sabrina", "Felipe", "Lorena", "Lorenzo", "Vinicius", "Samuel", "Joel", "Helena", "Jessica", "Benjamin", "Rodrigo", "Ronaldo", "Roberto", "Neymar", "Junior", "Diego", "Diogo", "Alessandra", "Alessandro", "Antonio", "Nicolas", "Julia", "Alice", "Sofia", "Alexandre", "Noah", "Calebe", "Joaquim", "Bryan", "Francisco", "Francisca", "Rute", "Pietro", "Pietra", "Reginaldo", "Marcelo", "Nazare", "Yuri", "Ian", "Murilo", "Theo", "Timoteo", "Ester", "Luiz", "Igor", "Emanuel", "Luan", "Augusto", "Jonatas", "Renan", "William", "Kate", "Megan", "Harry", "Eliazabeth", "Diana", "Wesley", "Douglas", "Danilo", "Israel", "Eric", "Erica", "Caue", "Jeferson", "Isaque", "Kauan", "Adriano", "Adriana", "Vicente", "Juçara", "Ryan", "Hugo", "Ariel", "Saulo", "Asafe", "Alex", "Italo", "Robson", "Moises", "Lia", "Raquel", "Rebeca", "Peggy", "Nelson", "Shirley", "Irene", "Gerson", "Carolina", "Claudia", "Rose", "Daniel", "Ravi", "Caique", "Giovane", "Estevao", "Amanda", "Rafaela", "Rafael", "Victor", "Richard", "Hiago", "Cesar", "Alisson", "Jonas", "Jonathan", "Emerson", "Antony", "Tom", "Nathan", "Julio", "Pablo", "Elias", "Josefa", "Tales", "Raul", "Ramon", "Wagner", "Patrick", "Frederico", "Ezequiel", "Martin", "Luther", "Juan", "Marlon", "Oliver", "Olivia", "Christian", "Anne", "Heloisa", "Efraim", "Jackson", "Whinderson", "Celson", "Eliana", "Castiel", "Rui", "Liam", "Larissa", "Camila", "Joana", "Lara", "Yasmin", "Fernanda", "Samara", "Lorena", "Cecilia", "Sara", "Bianca", "Melissa", "Nicole", "Flavia", "Suelen", "Emily", "Emilia", "Brenda", "Breno", "Priscila", "Alan", "Alan", "Hadassa", "Talita", "Alicea", "Clara", "Jenifer", "Mayara", "Ayla", "Eliza", "Tatiana", "Janaina", "Graziela", "Nina", "Carla", "Gisele", "Mirela", "Joice", "Goretty", "Luzia", "Greice", "Francine", "'Adelardo", "Abner", "Fatima", "Adelia", "Catarina", "Serena", "Paris", "Pamela", "Prince", "Poliana", "Tamires", "Roberta", "Olivia", "Thaynara", "Rita", "Perola", "Petala", "Ellen", "Maisa", "Sonia", "Abraão", "Jade", "Paloma", "Lilian", "Marcia", "Paola", "Eva", "Adão", "Glauber", "Monique", "Alexia", "Angela", "Angelica", "Michele", "Barack", "Sophie", "Raysa", "Ludmilla", "Anitta", "Marlene", "Iara", "Vania", "Valesca", "Sheila", "Betina", "Norberto", "Estela", "Dandara", "Edna", "Lana", "Katiuscia", "Vivian", "Marilia", "Tania", "Silvio", "Claudionor", "Jean", "Noemi", "Morgana", "Ketlyn", "Daniela", "Daniele", "Gabriela", "Gabriele", "Gabriel", "Merylin", "Tereza", "Kimberly", "Leonora", "Cassia", "Josiane", "Luma", "Marjore", "Leide", "Sirlene", "Cicero", "Sidnei", "Tarzan", "Jane", "Madalena", "Dalila", "Selma", "Telma", "Davi", "Kezia", "Heyde", "Rubia", "Yohanna", "Sebastiao", "Mia", "Naomi", "Pandora", "Matilda", "Clarissa", "Dafne", "Velma", "Fred", "Charles", "Marvin", "Andrew", "Francis", "Spencer", "Toby", "Aria", "John", "Ned", "Bart", "Homer", "Marge", "Lisa", "Milhouse", "Barney", "Selena", "Blair", "Troy", "Clark", "Agnes", "Lula", "Sandy", "Gary", "Leoncio", "Donatello", "Michelangelo", "George", "Judith", "Felicia", "Popeye", "Logan", "Scott", "Xavier", "Chico", "Ash", "Ben", "Timmy", "Wanda", "Kourtney", "Kendall", "Kylie", "Kim", "Justin", "Hailey", "Khloe", "Shawn", "Kanye", "Stephen", "Dakota", "Drake", "Travis", "Ed", "Adam", "Gloria", "Rihanna", "Sam", "Jason", "Freddy", "Kurt", "Darlene", "Madonna", "Miley", "Elton", "Cazuza", "Xuxa", "Taylor", "Britney", "Elvis", "Regina", "Hilton", "Akemy", "Gwen", "Eduardo", "Eduarda", "Eliel", "Naara", "Natalie", "Laisa", "Natalia", "Filipe", "Monica", "Magali", "Talina", "Sayonara", "Kelly", "Marisangila", "Manuela", "Karina", "Leticia", "Jaynara", "Franciele", "Juliana", "Juliano", "Leonidas", "Paula", "Jaime", "Laura", "Wellington", "Beatriz", "Weverton", "Taina", "Jacilene", "Mariano", "Jaciara", "Mariane", "Renata", "Renato", "Messi", "Cristiano", "Lionel", "Romario", "Kaka", "Tite", "Kevin", "Mohamed", "Abel", "Adalberto", "Adelaide", "Ademir", "Adolf", "Airton", "Olaf", "Carmeane", "Carmen", "Zelia", "ChidamBaram", "Cintia", "Claudionei", "Claudiomir", "Clovis", "Daiani", "Debora", "Deise", "Danubia", "Edgar", "Edino", "Helio", "Edson", "Edmar, Edgar", "Arlindo", "Lindomar", "Elisandra", "Emerson", "Evandro", "Everlin", "Evelyn", "Fabiola", "Fabricio", "Gilmar", "Gilson", "Greice", "Jucemar", "Eliete", "Helder", "Humberto", "Ivonete", "Ivo", "Jair", "Jailson", "Janine", "Jurema", "Katiane", "Leandro", "Otavio", "Ligia", "Lucio", "Maicon", "Marco", "Aurelio", "Marilene", "Milton", "Milagros", "Myrrena", "Nilson", "Nilton", "Olga", "Romulo", "Saimon", "Sandra", "Sandro", "Suzana", "Volnei", "Wagner", "Wesley", "Wilson", "Tony", "Mandy", "Josefina", "Norberto", "Taciane", "Silas", "Patricia", "Margarete", "Samela", "Jesse", "Valmir", "Vladimir", "Udo", "Fausto", "Lenon", "Ivan", "Silvia", "Silvana", "Rogerio", "Esdras", "Marcos", "Neemias", "Giordana", "Milena", "Milene", "Annabele", "Anabel", "Alexandra", "Tuani", "Kefera", "Tarso", "Lauren", "Camile", "Kelvin", "Kalvin", "Jucinei", "Liliane", "Kleber", "Nicolau", "Fagner", "Krisley", "Juscelino", "Marcel", "Eliza", "Eliseu", "Georgia", "Joana", "Isadora", "Isabel", "Isabeli", "Isabela", "Shayana", "Muana", "Heron", "Cleopatra", "Elisama", "Geisiane", "Ariadna", "Sergio", "Lucy", "Luciana", "Luciene", "Luciane", "Billy", "Bolsonaro", "Angelina", "Brad", "Fabiano", "Fabiana", "Fabiane", "Gilsiley", "Valdesio", "Mauricio", "Icaro", "Denise", "Jederson", "Angelo", "Mario", "Luigi", "Ligia", "Eleonai", "Sibele", "Perion", "Hector", "Evanir", "Franciele", "Vicente", "Caetano", "Crisley", "Kristen", "Cameron", "Edward", "Jacob", "Rosalie", "Tayler", "Phil", "Sasha", "Zac", "Hugh", "Jake", "Ralph", "Joseph", "Francisco", "Stephanie"};

        String[] firstName = {"Canguru", "Cao", "Gato", "Zebra", "Aguia", "Raposa", "Corvo", "Cavalo", "Macaco", "Tubarao","Golfinho", "Peixe", "Arraia", "Cobra", "Pinguim","Lontra", "Tucano", "Libelula", "Iguana", "Sapo","Tatu", "Arara", "Picapau", "Guaxinim", "Gamba","Dragao", "Sereia", "Girafa", "Baleia", "Caracol", "Babuino", "Bufalo", "Camelo", "Flamingo", "Chimpanze", "Coruja", "Ema", "Avestruz", "Elefante", "Foca", "Crocodilo", "Baleia", "Grilo", "Lemure", "Hipopótamo", "Iguana", "Coala", "Jabuti", "Lagarto", "Lagartixa", "Rato", "Pato", "Passaro", "Pardal", "Pelicano", "Pinguim", "Onça", "Leão", "Rinoceronte", "Pombo", "Tartaruga", "Tigre", "Serpente", "Sagui", "Urso", "Leopardo", "Panda", "Formiga", "Anaconda", "Iguana", "Ornitorrinco", "Lobo", "Periquito", "Gaviao", "Capivara", "Tamandua", "Porco", "Piranha", "Jiboia", "Jacare", "Abelha", "Andorinha", "Pavao", "Bufalo", "Cegonha", "Javali", "Morcego", "CavaloMarinho", "Orca", "Cervo", "Aranha", "Caranguejo", "Siri", "Camaleao", "Caramujo", "Coelho", "Cupim", "Escorpiao", "Gafanhoto", "Inseto", "Gorila", "Polvo", "Vespa", "Vagalume", "Gralha", "Porquinho", "Hamster", "Borboleta", "Guepardo", "Pantera", "Puma", "Molusco", "Barata", "Alga", "Alce", "Boto", "Ovelha", "Cabrito", "Castor", "Marmota", "Mariposa", "Caramujo", "Camundongo", "Jaguatirica", "Furao", "Ouriço", "Vaca", "Porco-Espinho", "Burro", "Esquilo"};

        String[] secondName = {"forte", "bravo", "veloz", "azulado", "branco","preto", "feliz", "escuro", "triste", "alegre", "rapido", "esverdeado", "claro", "trovejante", "marrom", "adoravel", "bruto", "covarde", "cruel", "devagar", "amarelado", "vermelho", "atrevido", "agressivo", "bondoso", "carismatico", "covarde", "calmo", "corajoso", "curioso", "dócil", "frio", "quente", "fofo", "franco", "intolerante", "humilde", "livre", "meigo", "medroso", "rosa", "sábio", "inteligente", "rude", "teimoso", "mau", "mal-humorado", "econômico", "livre", "cheio", "grande", "pequeno", "grandioso", "gigante", "minúsculo", "alto", "baixo", "longo", "curto", "novo", "velho", "especial", "fraco", "franco", "jovem", "ambicioso", "ansioso", "estranho", "lindo", "linda", "maravilhoso", "feio", "confiante", "capaz", "chato", "legal", "enorme", "esbelto", "experiente", "independente", "magricelo", "palito", "ousado", "sarado", "teimoso", "timido", "comprido", "pálido", "leve", "listrado", "xadrez", "calado", "sujo", "limpo", "cheiroso", "doente", "brilhoso", "cego", "raro", "silencioso", "dourado", "metálico", "prateado", "gelado", "fogoso", "sombrio", "ligeiro", "delicado", "furioso", "famoso", "elegante", "charmoso", "colorido", "surdo", "cego", "doido", "maluco", "selvagem", "pleno", "liso", "estampado", "magico", "invisível", "italiano", "chinês", "japonês", "irlandês", "americano", "africano", "molhado", "miúdo", "judeu", "incrível", "fatal", "assustador", "irritante", "manso", "loiro", "moreno", "europeu", "australiano", "feroz", "valioso", "careta", "pardo", "exausto", "adulto", "robusto", "rosado", "sorridente", "bizarro", "careca", "russo", "tosco", "genial", "barulhento", "rebelde", "acabado", "jovem", "exótico", "marinho", "terrestre", "magnifico"};

        String name = primaryName[rand.nextInt(primaryName.length)]
                + " " + firstName[rand.nextInt(firstName.length)]
                + secondName[rand.nextInt(secondName.length)];
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getLapTime() {
        return lapTime;
    }

    public void setLapTime(Time lapTime) {
        this.lapTime = lapTime;
    }

    public Date getLapDate() {
        return lapDate;
    }

    public void setLapDate(Date lapDate) {
        this.lapDate = lapDate;
    }

}
