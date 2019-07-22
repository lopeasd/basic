package com.learn.jvm.GC;

//1.对象在被GC是的自我拯救
//2.这种救赎只有一次，一个对象的finalize最多被系统调用一次
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //finalize优先级很低，暂停0.5秒执行
        try {
            Thread.sleep(500);
            if (SAVE_HOOK != null) {
                SAVE_HOOK.isAlive();
            } else {
                System.out.println("no, i am dead");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //相同代码执行一次，自救失败
        SAVE_HOOK = null;
        System.gc();
        //finalize优先级很低，暂停0.5秒执行
        try {
            Thread.sleep(500);
            if (SAVE_HOOK != null) {
                SAVE_HOOK.isAlive();
            } else {
                System.out.println("no, i am dead");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
