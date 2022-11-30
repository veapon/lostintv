package tv.lostin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tv.lostin.entity.FolderEntity;
import tv.lostin.request.FolderDTO;
import tv.lostin.response.FolderVO;
import tv.lostin.response.JsonResponse;
import tv.lostin.service.FolderService;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@RestController
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private FolderService folderService;

    /**
     * 添加文件夹
     *
     * @param dto
     * @return
     */
    @PutMapping("/")
    public JsonResponse<FolderVO> add(@RequestBody FolderDTO dto) {
        FolderEntity entity = folderService.add(dto);
        FolderVO vo = new FolderVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    /**
     * 更新文件夹
     *
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public JsonResponse<FolderVO> update(@RequestBody FolderDTO dto, @PathVariable(value = "id") Long id) {
        FolderEntity entity = folderService.update(id, dto);
        FolderVO vo = new FolderVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    /**
     * 文件夹列表
     *
     * @return
     */
    @GetMapping("/")
    public JsonResponse<List<FolderVO>> query() {
        List<FolderEntity> list = folderService.all();
        List<FolderVO> voList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(e -> {
                FolderVO vo = new FolderVO();
                BeanUtils.copyProperties(e, vo);
                voList.add(vo);
            });
        }
        return JsonResponse.success(voList);
    }

    /**
     * 文件夹信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResponse<FolderVO> info(@PathVariable(value = "id") Long id) {
        FolderEntity entity = folderService.info(id);
        FolderVO vo = new FolderVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    @GetMapping("/{id}/scan")
    public JsonResponse<Object> scan(@PathVariable(value = "id") Long id) throws Exception {
        folderService.scan(id);
        return JsonResponse.success();
    }
}
