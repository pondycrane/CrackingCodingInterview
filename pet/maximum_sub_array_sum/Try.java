class Try {
    Try(){
    }
    
    private static class GetSome {
        public int get;
        GetSome() {
            this.get = 1;
        }
    }

    public void runTest(GetSome shit) {
        System.out.println(shit.get);
    }

    public static void main(String[] args) {
        Try t = new Try();
        GetSome ha = new GetSome();
        t.runTest(ha);
    }
}
