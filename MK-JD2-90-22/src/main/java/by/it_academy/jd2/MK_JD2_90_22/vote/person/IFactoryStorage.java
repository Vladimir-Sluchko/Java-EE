package by.it_academy.jd2.MK_JD2_90_22.vote.person;

import by.it_academy.jd2.MK_JD2_90_22.vote.person.core.dto.StorageType;

public interface IFactoryStorage {
    IStorage getStorageByType(StorageType type);
}
