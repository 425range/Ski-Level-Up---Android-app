package com.example.skilevelup.ui.skill_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skilevelup.R
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.skilevelup.databinding.FragmentSkillListBinding

class SkillListFragment : Fragment() {

    private var _binding: FragmentSkillListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val skillListViewModel =
            ViewModelProvider(this).get(SkillListViewModel::class.java)

        _binding = FragmentSkillListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSnowplow.setOnClickListener {
            openSkillDetail("SnowPlow")
        }
        binding.btSnowplowTurn.setOnClickListener {
            openSkillDetail("SnowPlowTurn")
        }
        binding.btStemTurn.setOnClickListener {
            openSkillDetail("StemTurn")
        }
        binding.btParallelLong.setOnClickListener {
            openSkillDetail("ParallelLongTurn")
        }
        binding.btParallelShort.setOnClickListener {
            openSkillDetail("ParallelShortTurn")
        }
        binding.btDynamicLong.setOnClickListener {
            openSkillDetail("DynamicLongTurn")
        }
        binding.btDynamicShort.setOnClickListener {
            openSkillDetail("DynamicShortTurn")
        }
        binding.btCarvingLong.setOnClickListener {
            openSkillDetail("CarvingLongTurn")
        }
        binding.btCarvingShort.setOnClickListener {
            openSkillDetail("CarvingShortTurn")
        }
        binding.btCombinedDownhill.setOnClickListener {
            openSkillDetail("CombinedDownhill")
        }
        binding.btSlalomRacing.setOnClickListener {
            openSkillDetail("SlalomRacing")
        }
        binding.btGiantSlalomRacing.setOnClickListener {
            openSkillDetail("GiantSlalomRacing")
        }
    }
    private fun openSkillDetail(skillName: String) {
        val bundle = bundleOf("skillName" to skillName)
        findNavController().navigate(
            R.id.action_skillList_to_skillDetail,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}