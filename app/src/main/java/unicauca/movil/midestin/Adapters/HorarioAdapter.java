package unicauca.movil.midestin.Adapters;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.midestin.R;
import unicauca.movil.midestin.databinding.TemplateHorarioBinding;


import unicauca.movil.midestin.util.H;
import unicauca.movil.midestin.util.L;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder>{

    public interface OnHorarioListener{
        void onHorario(View v);
    }
    LayoutInflater inflater;
    HorarioAdapter.OnHorarioListener onHorarioListener;

    public HorarioAdapter(LayoutInflater inflater, HorarioAdapter.OnHorarioListener onHorarioListener){
        this.onHorarioListener= onHorarioListener;
        this.inflater= inflater;
    }

    @Override
    public HorarioAdapter.HorarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_horario,parent,false);
        HorarioAdapter.HorarioViewHolder holder = new HorarioAdapter.HorarioViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(HorarioAdapter.HorarioViewHolder holder, int position) {
        holder.binding.setHor(H.data.get(position));
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {

        return H.data.size();
    }

    public void onClickHorario (View v){
        onHorarioListener.onHorario(v);

    }


//Retorna tipo de variable o celda
 /*   @Override
    public int getItemViewType(int position) {
        return 0;
    }

    */

    public  static class HorarioViewHolder extends RecyclerView.ViewHolder{
        TemplateHorarioBinding binding;
        public HorarioViewHolder(View itemView) {
            super(itemView);

            binding= DataBindingUtil.bind(itemView);

        }
    }
}
