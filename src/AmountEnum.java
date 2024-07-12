public enum AmountEnum {
    UN_MILLON{
        @Override
        public String toString() {
            return "Un millon";
        }

        @Override
        public String[] getFileName(FormatEnum formatEnum) {
            return new String[]{formatEnum.getAllFormatOptions()[1], formatEnum.getAllFormatOptions()[0]};
        }
    },
    QUINCE_MILLONES{
        @Override
        public String toString() {
            return "Quince millones";
        }
        @Override
        public String[] getFileName(FormatEnum formatEnum) {
            return new String[]{formatEnum.getAllFormatOptions()[2], formatEnum.getAllFormatOptions()[0]};
        }
    },
    COMPLETO{
        @Override
        public String toString() {
            return "Completo";
        }
        @Override
        public String[] getFileName(FormatEnum formatEnum) {
            return new String[]{formatEnum.getAllFormatOptions()[3], formatEnum.getAllFormatOptions()[0]};
        }
    };
    public abstract String[] getFileName(FormatEnum formatEnum);
}
