package com.library.system.modules.file.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import cn.xuyanwu.spring.file.storage.exception.FileStorageRuntimeException;
import com.library.common.constant.Constants;
import com.library.common.enums.ErrorCodeEnum;
import com.library.system.modules.file.bo.UploadFileBO;
import com.library.system.modules.file.entity.File;
import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.library.system.modules.file.mapper.FileMapper;
import com.library.system.modules.file.struct.FileStructMapper;
import com.library.system.modules.file.service.FileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import com.library.common.util.PageCovertUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @Author makejava
 * @Desc 使用者資料表(File)表服务实现类
 * @Date 2026-02-12 20:01:39
 */

@Log4j2
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Resource
    private FileStructMapper fileStructMapper;
    @Resource
    private FileMapper fileMapper;


    @Override
    public IPage<FileVO> queryByPage(FilePage page) {
        // 查询条件
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        // 查询分页数据
        Page<File> filePage = new Page<File>(page.getCurrent(), page.getSize());
        IPage<File> pageData = baseMapper.selectPage(filePage, queryWrapper);

        //转换成vo
        IPage<FileVO> records = PageCovertUtil.pageVoCovert(pageData, FileVO.class);
        return records;
    }


    @Override
    public FileVO queryById(Integer id) {
        File file = baseMapper.selectById(id);
        return fileStructMapper.fileToFileVO(file);
    }

    @Override
    public FileVO getFileBySign(String fileSign){
        File one = lambdaQuery().eq(File::getFileSign, fileSign).one();
        return fileStructMapper.fileToFileVO(one);
    }

    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }

    @Resource
    private FileStorageService fileStorageService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileVO upload(MultipartFile file, UploadFileBO bo){
        FileInfo fileInfo = null;
        try{
            fileInfo = fileStorageService.of(file).setContentType(file.getContentType()).upload();
        }
        catch (FileStorageRuntimeException e){
            log.error("檔案上傳失敗, 檔案名稱: {}, 錯誤資訊: ", file.getOriginalFilename(), e);
        }
        log.info("檔案上傳成功, 檔案名稱: {}", file.getOriginalFilename());
        File insert = this.insert(fileInfo, bo);
        return fileStructMapper.fileToFileVO(insert);
    }

    /**
     * 檔案資訊儲存
     *
     * @param fileInfo
     * @return
     */
    public File insert(FileInfo fileInfo, UploadFileBO bo){
        File file = new File();
        file.setUsername(bo.getUsername());
        file.setFileSize(fileInfo.getSize());
        file.setFileSign(bo.getFileSign());
        file.setExt(fileInfo.getExt());
        file.setBasePath(fileInfo.getBasePath());
        file.setObjectType(bo.getObjectType());
        file.setOriginalFilename(fileInfo.getOriginalFilename());
        file.setStoragePath(fileInfo.getPath());
        file.setStorageFilename(fileInfo.getFilename());
        file.setStoragePlatform(fileInfo.getPlatform());
        file.setUrl(fileInfo.getUrl());
        this.save(file);
        return file;
    }
}
