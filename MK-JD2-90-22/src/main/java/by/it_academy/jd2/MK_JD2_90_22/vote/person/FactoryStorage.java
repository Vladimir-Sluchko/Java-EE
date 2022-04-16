package by.it_academy.jd2.MK_JD2_90_22.vote.person;

import by.it_academy.jd2.MK_JD2_90_22.vote.person.core.dto.StorageType;

public class FactoryStorage implements IFactoryStorage{
    @Override
    public IStorage getStorageByType(StorageType type) {
        if(type.equals(StorageType.SESSION)){
            return new SessionStorage();
        } else if(type.equals(StorageType.COOKIES)){
            return new CookieStorage();
        } else {
            throw new IllegalStateException("Нет реализации для данного хранилища");
        }
    }
}
