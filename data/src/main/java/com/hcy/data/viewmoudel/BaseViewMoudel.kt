package com.hcy.data.viewmoudel

import androidx.lifecycle.*
import com.hcy.data.bean.Base
import com.hcy.data.repository.BaseRepository
import kotlinx.coroutines.launch

/**
 * description :
 * @author HCY
 * @date 2021/4/12
 */
class BaseViewMoudel(private val repository: BaseRepository) : ViewModel() {


    val allBase: LiveData<List<Base>> = repository.allBase.asLiveData()

    fun insert(pBase: Base) = viewModelScope.launch {
        repository.insert(pBase)
    }


}


class BaseViewMoudelFactory(private val repository: BaseRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BaseViewMoudel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BaseViewMoudel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
