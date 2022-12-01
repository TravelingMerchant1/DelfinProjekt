enum SvømmeDisciplin {


    BUTTERFLY("BUTTERFLY"),
    CRAWL("CRAWL"),
    RYGCRAWL("RYGCRAWL"),
    BRYSTSVÆMNING("BRYSTSVØMNING");

    public String getSvømmeDisciplin() {
        return svømmeDisciplin;
    }

    private final String svømmeDisciplin;

    private SvømmeDisciplin(String svømmeDisciplin){
        this.svømmeDisciplin = svømmeDisciplin;
    }

}
