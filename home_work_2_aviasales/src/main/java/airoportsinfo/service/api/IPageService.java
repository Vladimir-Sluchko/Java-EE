package airoportsinfo.service.api;

import airoportsinfo.dao.dto.Page;

public interface IPageService {
    Page countPage(String countPage, Page page);

}
