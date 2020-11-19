package src;

public class LOVHero extends Hero{
    private Marker marker;
    private int heroNum;

    protected int cellStre;
    protected int cellAgi;
    protected int cellDex;


    public LOVHero(String n, int mana, int stre, int agi, int dex, int money, int exp, Marker marker, int heroNum, int cellStre, int cellAgi, int cellDex) {
        super(n, mana, stre, agi, dex, money, exp);
        this.marker = marker;
        this.heroNum = heroNum;
        this.cellStre = cellStre;
        this.cellAgi = cellAgi;
        this.cellDex = cellDex;
    }

    public LOVHero(Hero hero, Marker marker){
        super(hero.getName(), hero.getMana(), hero.getStre(), hero.getAgi(), hero.getDex(), hero.getMoney(), hero.getExp());
        this.marker = marker;
        this.cellAgi =0;
        this.cellDex =0;
        this.cellStre =0;
    }

    public void setHeroPosition(LOVBoard board, int row, int col){
        //leaveHeroPosition(board);
        board.setCellIsHero(heroNum, row, col);
        this.row = row;
        this.col = col;
        char celltype = board.getCelltype(row, col);
        if(celltype=='B'){
            this.dexterity += this.dexterity*0.1;
        }else if(celltype == 'C'){
            this.agility += this.agility*0.1;
        }else if(celltype=='K'){
            this.strength += this.strength*0.1;
        }
    }

    public int getCellStre() {
        return cellStre;
    }

    public int getCellAgi() {
        return cellAgi;
    }

    public int getCellDex() {
        return cellDex;
    }

    public void setCellStre(int cellStre) {
        this.cellStre = cellStre;
    }

    public void setCellAgi(int cellAgi) {
        this.cellAgi = cellAgi;
    }

    public void setCellDex(int cellDex) {
        this.cellDex = cellDex;
    }

    public int getStreWithBoost() {
        return this.strength+ this.cellStre;
    }
    public int getAgilWithBoost() {
        return this.agility+ this.cellAgi;
    }
    public int getDexWithBoost() {
        return this.dexterity+ this.cellDex;
    }


}
