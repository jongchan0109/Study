class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    private int prevChannel;
    public void setVolume(int volume){
        if(MIN_VOLUME>volume || MAX_VOLUME <volume)
            return;
        this.volume = volume;
    }
    public void setChannel(int channel){
        if(MIN_CHANNEL>channel || MAX_CHANNEL <channel){
            return;
        }
        prevChannel =this.channel;
        this.channel = channel;
    }
    public int getVolume(){
        return volume;
    }
    public int getChannel(){
        return channel;
    }
    public void gotoPrevChannel(){
        setChannel(prevChannel);
    }
}

class Exercise7_11 {
    public static void main(String args[]) {
        MyTv2 t = new MyTv2();
        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}