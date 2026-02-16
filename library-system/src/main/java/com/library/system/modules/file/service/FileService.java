package com.library.system.modules.file.service;

import cn.hutool.core.net.multipart.UploadFile;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import com.library.system.modules.file.bo.UploadFileBO;
import com.library.system.modules.file.entity.File;
import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author makejava
 * @Desc 使用者資料表(File)表服务接口
 * @Date 2026-02-12 20:01:39
 */
public interface FileService extends IService<File> {

    /**
     * 分页查询
     */
    IPage<FileVO> queryByPage(FilePage page);

    /**
     * 根据ID查详情
     */
    FileVO queryById(Integer id);

    /**
     *查詢檔案是否存在
     * @param fileSign
     * @return
     */
    FileVO getFileBySign(String fileSign);

    /**
     * 上傳檔案
     *
     * @param file 圖片檔案
     * @param bo   上傳檔案資訊
     * @return
     */
    //FileVO upload(MultipartFile file, UploadFileBO bo);

    /**
     * 修改数据
     */
    //boolean update(FileUpdate fileUpdate);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

    FileVO upload(MultipartFile file, @Valid UploadFileBO bo);
}