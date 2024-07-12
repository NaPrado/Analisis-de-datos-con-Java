import querys.Format;

public enum FormatEnum {
    NYC{
        @Override
        public Format getFormat() {
            return Format.NY;
        }
        @Override
        public String toString() {
            return "Nueva York";
        }

        @Override
        public String[] getAllFormatOptions() {
            return new String[]{"infractionsNYC.csv", "ticketsNYC1000000.csv","ticketsNYC15000000.csv","ticketsNYC.csv"};
        }
    },
    CHI{
        @Override
        public Format getFormat() {
            return Format.CHI;
        }

        @Override
        public String toString() {
            return "Chicago";
        }
        @Override
        public String[] getAllFormatOptions() {
            return new String[]{"infractionsCHI.csv", "ticketsCHI1000000.csv", "ticketsCHI15000000.csv","ticketsCHI.csv"};
        }
    };
    public abstract Format getFormat();
    public abstract String[] getAllFormatOptions();
}
