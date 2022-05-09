export class Singleton { 
    private static INSTANCE: Singleton; 

    private constructor() {} 

    static getInstance() { 
        if (!Singleton.INSTANCE) { 
            Singleton.INSTANCE = new Singleton(); 
        } 
        return Singleton.INSTANCE; 
    } 
}
