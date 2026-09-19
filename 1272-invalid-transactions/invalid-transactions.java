class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> al=new ArrayList<>();
        for(int i=0;i<transactions.length;i++)
        {
            String a[]=transactions[i].split(",");
            String name=a[0];
            int time=Integer.parseInt(a[1]);
            int amount=Integer.parseInt(a[2]);
            String city=a[3];

            boolean invalid=false;
            if(amount>1000)
                invalid=true;
            for(int j=0;j<transactions.length;j++)
            {
                if(i==j) continue;

                String b[]=transactions[j].split(",");
                String name1=b[0];
                int time1=Integer.parseInt(b[1]);
                String city1=b[3];
                if(name.equals(name1) && !city.equals(city1) && Math.abs(time-time1)<=60)
                {
                    invalid=true;
                    break;
                }
            }
            if(invalid)
                al.add(transactions[i]);
        }
        return al;
    }
}