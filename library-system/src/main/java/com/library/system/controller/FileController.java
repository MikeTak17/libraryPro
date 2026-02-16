package com.library.system.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.library.common.enums.ErrorCodeEnum;
import com.library.system.modules.file.bo.UploadFileBO;
import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.library.system.modules.file.service.FileService;
import com.library.system.modules.file.vo.UploadFileInfoVO;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;


/**
 * @Author makejava
 * @Desc 使用者資料表(File)表控制层
 * @Date 2026-02-12 20:01:39
 */

@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileService fileService;


    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @GetMapping("/list")
    public Result<IPage<FileVO>> queryByPage(@Valid FilePage page) {
        return Result.success(fileService.queryByPage(page));
    }

    /**
     * 根据ID获取数据
     *
     * @return 单个使用者資料表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<FileVO> queryById(@PathVariable("id") Integer id) {
        return Result.success(fileService.queryById(id));
    }

    /**
     * 删除使用者資料表
     *
     * @return 删除使用者資料表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        fileService.deleteById(id);
        return Result.success();
    }

    /**
     * 上傳圖片
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<UploadFileInfoVO> uploadImg(@PathVariable("file") MultipartFile file, @Valid UploadFileBO bo) throws IOException{
        if (file == null){
            return Result.error(ErrorCodeEnum.FILE_NONE.getCode(), "上傳的檔案為空");
        }
        //檢測圖片是否存在,產生唯一「檔案指紋」
        String sign = DigestUtil.md5Hex(file.getBytes());
        //查資料庫是否已存在
        FileVO vo = fileService.getFileBySign(sign);
        if (vo == null){
            bo.setFileSign(sign);
            vo = fileService.upload(file, bo);
        }
        UploadFileInfoVO infoVO = UploadFileInfoVO.builder().filename(vo.getOriginalFilename()).url(vo.getUrl()).build();
        return Result.success(infoVO);
    }
}
