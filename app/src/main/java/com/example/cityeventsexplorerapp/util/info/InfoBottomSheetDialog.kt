package com.example.cityeventsexplorerapp.util.info

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.base.BaseBottomSheetDialogFragment
import com.example.cityeventsexplorerapp.databinding.BottomSheetInfoBinding
import com.example.coreui.delegate.viewBinding
import com.example.coreui.extensions.parcelableOrThrow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoBottomSheetDialog :
    BaseBottomSheetDialogFragment<BottomSheetInfoBinding, InfoDialogViewModel>() {

    override val viewModel: InfoDialogViewModel by viewModels()
    override val layoutId: Int = R.layout.bottom_sheet_info

    private val binding by viewBinding(BottomSheetInfoBinding::bind)
    private val args by lazy { arguments.parcelableOrThrow<InfoDialogArgs>(KEY_ARGS) }

    override fun initView() = with(binding) {
        tvTitle.text = args.title
        tvMessage.text = args.message
        btnAction.text = args.buttonText
        btnAction.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        private const val PACKAGE = "package"
        private const val KEY_ARGS = "key_args"
        const val TAG = "InfoBottomSheetDialog"

        fun newInstance(args: InfoDialogArgs) = InfoBottomSheetDialog().apply {
            arguments = bundleOf(KEY_ARGS to args)
        }
    }
}